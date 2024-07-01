package cl.uchile.dcc
package patternmatching

sealed trait Device

case class Phone(model: String) extends Device {
  def screenOff = "Turning screen off"
}

case class Computer(model: String) extends Device {
  def screenSaverOn = "Turning screen saver on..."
}

def goIdle(device: Device): String = device match {
  case p: Phone => p.screenOff
  case c: Computer => c.screenSaverOn
}
