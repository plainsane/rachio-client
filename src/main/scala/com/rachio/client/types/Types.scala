package com.rachio.scala.client.types
import spray.json.{DefaultJsonProtocol, JsonFormat}

case class PersonId(id:String)

case class Person(
  email:String,
  username:String,
  fullName:String,
  devices:List[Device],
  enabled:Boolean
)

case class Device(
  id:String,
  timezone:String,
  latitude:Double,
  longitude:Double,
  zip:String,
  name:String,
  zones:List[Zone],
  scheduleRules:List[FixedScheduleRules],
  serialNumber:String,
  rainDelayExpirationDate:Int,
  rainDelayStartDate:Int,
  macAddress:String,
  elevation:Double,
  webhooks:List[String],
  paused:Boolean,
  on:Boolean,
  flexScheduleRules:List[FlexScheduleRules],
  utcOffset:Int
)

case class Zone(
  id:String,
  zoneNumber:Int,
  name:String,
  enabled:Boolean,
  customNozzel:Nozzel,
  availableWater:Int,
  rootZoneDepth:Int,
  managementAllowedDepletion:Double,
  efficiency:Double,
  yardAreadSquareFeet:Int,
  irrigationAmount:Int,
  depthOfWater:Double,
  runtime:Int
)

case class Nozzel(
  name:String,
  imageUrl:String,
  category:String,
  inchesPerHour:Double
)

case class FlexScheduleRules(id:String)
case class FixedScheduleRules(id:String)

object RachioJsonProtocol extends DefaultJsonProtocol {
  implicit val personIdResultFormat = jsonFormat1(PersonId.apply)
  implicit val personResultFormat = jsonFormat5(Person.apply)
  implicit val deviceResultFormat = jsonFormat18(Device.apply)
  implicit val zoneResultFormat = jsonFormat13(Zone.apply)
  implicit val nozzelFormat = jsonFormat4(Nozzel.apply)
  implicit val flexScheduleRulesFormat = jsonFormat1(FlexScheduleRules.apply)
  implicit val fixedScheduleRulesFormat = jsonFormat1(FixedScheduleRules.apply)
}
