2,1

cloud,0,100,1000,1000000,10240,10.0,FOG_DEVICE
mobile_0,1,1000,1000,1000,1024,0.0,FOG_DEVICE
mobile_1,1,1000,1000,1000,1024,0.0,FOG_DEVICE
motor_0,MOTOR,Actuator
temp_0,TEMP,1,10.0,2.0,SENSOR
motor_1,MOTOR,Actuator
temp_1,TEMP,1,10.0,2.0,SENSOR

1.0,mobile_0,cloud
1.0,mobile_1,cloud
2.0,motor-0,mobile-0
2.0,motor-1,mobile-1
2.0,temp-0,mobile-0
2.0,temp-1,mobile-1

AppM,mobile_0,1000,1000
temp_0,mobile_0,30000,10*1024,temp_0,UP,SENSOR
mobile_0,motor_0,1000,1*1024,motor_0,DOWN,ACTUATOR
TUPLE,MODULE,temp_0,module_0

module placement is done to show the flow of data transmission. Here data from temp_0 will be send to mobile_0 and then after some calculation data from mobile_0 will be send to motor_0.

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

DETAIL INFORMATION FOR ABOVE DATA(PARAMETERS)

2,1//By (2,1)i mean, 1st 2 line will be read from 1st set of lines and 1 line will be read from 2nd set of line.
1st set of lines constitute set of nodes(fogdevices,Sensor,actuators). Last paramter denotes node type.
2nd set of lines constitute links between the above specified nodes. 


name,level,Uplink BW,Downlink BW,Mips,Ram,Rate/Mips --Fog node
name,Actuator type--Actuator
name,Type,Distribution,Mean Std Dev,min,max,value--Sensor
          1 Normal,Mean,Std Dev
	  2 Uniform,Min,Max
          3 Deterministic,value

links:
latency,source,Destination

module:
module placement is done to show the flow of data transmission. Here data from temp_0 will be send to mobile_0 and then after some calculation data from mobile_0 will be send to motor_0.
Doubt: 
How each module placement data be placed in a single line  instead of 4 lines for one module placement ?
How we can read the specific lines and perform usual operation.



			
