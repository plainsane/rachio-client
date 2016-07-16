package com.rachio.scala.client.types
import spray.json.DefaultJsonProtocol
import spray.json._
case class PersonId(id:String)

case class Person(
  email:String,
  username:String,
  fullName:String,
  devices:List[Device],
  enabled:Boolean,
  displayUnit:String,
  roles:List[String],
  managedDevices:List[Device]
)

case class Device(
  id:String,
  status:String,
  timeZone:String,
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
  utcOffset:Int,
  scheduleModeType:String,
  model:String
)
case class Slope(
  variance: String,
  imageUrl:String,
  name:String,
  sortOrder:Int
)

case class Crop(
  coefficient:Double,
  imageUrl:String,
  name:String
)

case class Soil(
  category:String,
  name:String,
  lastUpdateDate: Int,
  imageUrl:String,
  editable: Boolean,
  infiltrationRate:Double,
  createDate:Int,
  percentAvailableWater:Double,
  id:String
)

case class Zone(
  id:String,
  zoneNumber:Int,
  name:String,
  enabled:Boolean,
  customNozzle:Nozzel,
  availableWater:Double,
  rootZoneDepth:Double,
  managementAllowedDepletion:Double,
  efficiency:Double,
  yardAreaSquareFeet:Int,
  depthOfWater:Double,
  runtime:Int,
  //maxRuntime:Int,
  scheduleDataModified:Boolean,
  lastWateredDuration:Int,
  //fixedRuntime:Int,
  wateringAdjustmentRuntimes:Map[String, Int],
  customSlope:Slope,
  runtimeNoMultiplier:Int,
  lastWateredDate:Int,
  saturatedDepthOfWater:Double,
  imageUrl:String,
  customCrop:Crop,
  customSoil:Soil
)

case class Nozzel(
  name:String,
  imageUrl:String,
  category:String,
  inchesPerHour:Double
)

case class ZoneScheduleElement(
  zoneNumber:Int,
  sortOrder:Int,
  zoneId:String
)

case class FlexScheduleRules(
  startDate:Int,
  name:String,
  enabled:Boolean,
  summary:String,
  zones:List[ZoneScheduleElement],
  externalName:String,
  totalDuration:Int,
  cycleSoak:Boolean,
  scheduleJobTypes:List[String],
  `type`:String,
  id:String,
  totalDurationNoCycle:Int
)

case class FixedScheduleRules(
  id:String,
  rainDelay:Boolean,
  scheduleJobTypes:List[String],
  startDate:Int,
  cycles:Int,
  cycleSoakStatus:String,
  name:String,
  enabled:Boolean,
  waterBudget:Boolean,
  totalDuration:Int,
  summary:String,
  zones:List[ZoneScheduleElement],
  weatherIntelligenceSensitivity:Double,
  externalName:String,
  cycleSoak:Boolean,
  seasonalAdjustment:Double,
  totalDurationNoCycle:Int
)

object RachioJsonProtocol extends DefaultJsonProtocol {
  implicit val soilFormat = jsonFormat9(Soil)
  implicit val cropFormat = jsonFormat3(Crop)
  implicit val slopeFormat = jsonFormat4(Slope)
  implicit val nozzelFormat = jsonFormat4(Nozzel)
  implicit val zoneScheduleElementFormat = jsonFormat3(ZoneScheduleElement)
  implicit val flexScheduleRulesFormat = jsonFormat12(FlexScheduleRules)
  implicit val fixedScheduleRulesFormat = jsonFormat17(FixedScheduleRules)
  implicit val personIdResultFormat = jsonFormat1(PersonId)
  implicit val zoneResultFormat = jsonFormat22(Zone)
  implicit val deviceResultFormat = jsonFormat21(Device)
  implicit val personResultFormat = jsonFormat8(Person)
}

