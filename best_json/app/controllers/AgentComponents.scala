package controllers

import play.api.mvc._
import play.api.libs.json._
import play.Logger


object AgentComponents extends Controller {

  def checkbox = Action {
    Ok(views.html.checkboxes())
  }

  def jsonexample = Action {
    Ok(views.html.json())
  }
  
  def getTreeFromBrowser = Action(parse.json) {
    request =>
      val treeJson = request.body

      Logger debug treeJson.toString()

      Ok("got your json")
  }

  def sendTreeToBrowser = Action {
    val treeJson: JsValue = Json.parse("""
      [
        {"title": "Item 1"},
        {"title": "Folder 666", "isFolder": true, "key": "folder2",
          "children": [
        {"title": "Sub-item 2.1"},
        {"title": "Sub-item 2.2"}
          ]
        },
        {"title": "Folder 3", "isFolder": true, "key": "folder3",
          "children": [
        {"title": "Sub-item 3.1"},
        {"title": "Sub-item 3.2"}
          ]
        },
        {"title": "Lazy Folder 4", "isFolder": true, "isLazy": true, "key": "folder4"},
        {"title": "Item 5"}
        ]
    """)

    Logger debug treeJson.toString()

    Ok(treeJson)
  }

}