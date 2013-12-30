package models

import akka.actor.ActorRef

object Message {
  case class  GotFilesystem(agent: String, files: List[String])
  case class  StartPeriodicCheck(agent: ActorRef, files: List[String])
  case class  GotDone(agent: ActorRef)
  case class  GotPeriodicCheckFail(agent: ActorRef, fail: List[String])
  case object AdminsFix
  case class  GotMadeFix(agent:ActorRef)
}
