latlongcalc
===========

Grails plugin which given a range, longitude and latitude value :  will return min/max values of longitude and latitude




Sample Controller call to this plugin:

			import grails.groovy.plugin.latlongcalc.CalcLatLong
			
			//import grails.java.plugin.latlongcalc.CalcLatLong
			
			class LinkController {
			
			    def index() { }
			
				def calcthis() {
					// This will calculate the min max values of a latlong value with a given range
					//CalcLatLong cl=new CalcLatLong(range,Longitude,Latitude) 
					
					
					// USING DECLARATION:
					/*
					 * import grails.java.plugin.latlongcalc.CalcLatLong
					 */
					
					/*
					CalcLatLong cl=new CalcLatLong('30','10.810547','4.017699')
					println cl.Result()
					def longtmin=cl.ret_longtmin()
					def longtmax=cl.ret_longtmax()
					def latmin=cl.ret_latmin()
					def latmax=cl.ret_latmax()
					println "LONGTMAX:"+cl.ret_longtmax()
					println "LONGTMIN:"+cl.ret_longtmin()
					println "LATMIN:"+cl.ret_latmin()
					println "LATMAX:"+cl.ret_latmax()
					*/
					
					/*returns:
					[ latmin:3.582916391304348, latmax:4.452481608695653, longtmin:10.37469326090218, longtmax:11.246400739097819 ]
					LONGTMAX:11.246400739097819
					LONGTMIN:10.37469326090218
					LATMIN:3.582916391304348
					LATMAX:4.452481608695653*/
					
					//Declaration : import grails.groovy.plugin.latlongcalc.CalcLatLong
					CalcLatLong cl=new CalcLatLong();
					cl.range='30'
					cl.longt='10.810547'
					cl.lat='4.017699'
					// THIS MUST BE DONE BEFORE ATTEMPTING TO GET return values
					def myoutput=cl.Result()
					
					println "RESULT: "+myoutput
			
					double dlongtmin=cl.ret_dlongtmin()
					double dlongtmax=cl.ret_dlongtmax()
					double dlatmin=cl.ret_dlatmin()
					double dlatmax=cl.ret_dlatmax()
					
					println "LONGTMAX:"+dlongtmax
					println "LONGTMIN:"+dlongtmin
					println "LATMIN:"+dlatmin
					println "LATMAX:"+dlatmax
			
					/* RETURNS:
					 * 
					 */
					/*RESULT: [ latmin:3.582916391304348, latmax:4.452481608695653, longtmin:10.37469326090218, longtmax:11.246400739097819 ]
					LONGTMAX:11.246400739097819
					LONGTMIN:10.37469326090218
					LATMIN:3.582916391304348
					LATMAX:4.452481608695653*/
					
					
					/*Assuming you have a postcode domain which holds all postcodes and lat/long values 
					  + with above call 
					  + below query 
					  = All valid postcodes in that range
			
					class PostCodes {
						
						String postcode
						double longitude
						double latitude
						
					}*/
			
					
					def result=PostCodes.findByLongitudeBetweenAndLatitudeBetween(dlongtmin,dlongtmax,dlatmin,dlatmax)
						result.each{ found->
							output+=found.postcode
						}
					
				}
			}
