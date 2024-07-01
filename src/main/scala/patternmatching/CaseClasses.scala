package cl.uchile.dcc
package patternmatching

sealed trait Notification

case class Email(sender: String, title: String, body: String)
  extends Notification

case class SMS(caller: String, message: String)
  extends Notification

case class VoiceRecording(contactName: String, link: String)
  extends Notification

def showNotification(notification: Notification): String = {
  notification match {
    case Email(sender, title, _) =>
      s"You got an email from $sender with title: $title"
    case SMS(number, message) =>
      s"You got an SMS from $number! Message: $message"
    case VoiceRecording(name, link) =>
      s"You received a Voice Recording from $name! Click the link to hear it: $link"
  }
}

def showNotification(notification: Notification, importantPeopleInfo: Seq[String]): String = {
  notification match {
    case Email(sender, _, _) if importantPeopleInfo.contains(sender) =>
      "You got an email from special someone!"
    case SMS(number, _) if importantPeopleInfo.contains(number) =>
      "You got an SMS from special someone!"
    case other =>
      // Fallback to the original implementation
      showNotification(other)
  }
}

@main def testNotification(): Unit = {
  println(showNotification(SMS("12345", "Are you there?")))
  // prints You got an SMS from 12345! Message: Are you there?
  val importantPeopleInfo = Seq("867-5309", "victor.nikiforov@gmail.com")
  println(
    showNotification(
      Email(
        "victor.nikiforov@gmail.com",
        "Yuuri, starting today, I'm your coach.",
        "I'll make you win the Grand Prix Final."
      ), importantPeopleInfo)
  )
  // prints You got an email from special someone!
}