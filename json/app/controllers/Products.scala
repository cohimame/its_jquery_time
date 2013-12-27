package controllers

import play.api.mvc.{Action, Controller}
import models.Product
import models.Message._

import play.api.libs.json._
import play.api.libs.functional.syntax._

object Products extends Controller {

  def list = Action {
    val productCodes = Product.findAll.map(_.ean)
    Ok(Json.toJson(productCodes)/*(implicit tjs: Writes[List])*/)
  }

  implicit object GotFilesystemWrites extends Writes[GotFilesystem] {
    def writes(message: GotFilesystem) = Json.obj(
      "agentAddress" -> Json.toJson(message.agent),
      "filesystem" -> Json.toJson(message.files)
    )
  }

  def filesystem = Action {
    val agent = s"akka://10.11.11.2@agent/user/agentActor"
    val files = List(s"/home/dir", s"core.cpp")

    val agentFs = GotFilesystem(agent, files)
    val fsJson = Json.toJson(agentFs)

    Ok(fsJson)
  }

  def fschain = Action {
    val jsonInts = Json.toJson(List(1,2,3))
    val jsonChars = Json.toJson(List("a","b","c"))
    val composed = Json.obj("ints"  -> jsonInts,
                            "chars" -> jsonChars)
    Ok(composed)
  }

  implicit object ProductWrites extends Writes[Product] {
    def writes(p: Product) = Json.obj(
      "ean" -> Json.toJson(p.ean),
      "name" -> Json.toJson(p.name),
      "description" -> Json.toJson(p.description)
    )
  }

  implicit val productReads: Reads[Product] = (
    (JsPath \ "ean").read[Long] and
      (JsPath \ "name").read[String] and
      (JsPath \ "description").read[String]
    )(Product.apply _)

  def details(ean: Long) = Action {
    Product.findByEan(ean).map {
      product => Ok(Json.toJson(product))
    }.getOrElse(NotFound)    
  }

  def save(ean: Long) = Action(parse.json) {
    request => 
      val productJson = request.body
      val product = productJson.as[Product]

      try { 
        Product.save(product)
        Ok("Saved")
      } catch {
        case e: IllegalArgumentException =>
          BadRequest("Product not found") 
      }
  }


}