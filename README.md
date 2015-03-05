latlongcalc
===========

Grails plugin which given a range, longitude and latitude value :  will return min/max values of longitude and latitude

To wrap the plugin call into a service/taglib and call within your views refer to https://github.com/vahidhedayati/RemoteSSH which has an example

### Grails 2.X
```
compile latlongcalc:0.1
```


Sample Controller call to this plugin:

    import grails.plugin.latlongcalc.CalcLatLong

    class LinkController {

       def index() { }

       def calcthis() {
          // This will calculate the min max values of a latlong value with a given range
          //CalcLatLong cl=new CalcLatLong(range,Longitude,Latitude)

          CalcLatLong cl = new CalcLatLong()
          def values = cl.parse(30, 10.810547, 4.017699)

          double lonmin = values.lonmin
          double lonmax = values.lonmax
          double latmin = values.latmin
          double latmax = values.latmax

          println "LONMAX: $lonmax"
          println "LONMIN: $lonmin"
          println "LATMIN: $latmin"
          println "LATMAX: $latmax"

          /*prints:
            LONGTMAX: 11.246400739097819
            LONGTMIN: 10.37469326090218
            LATMIN: 3.582916391304348
            LATMAX: 4.452481608695653*/

          /*Assuming you have a postcode domain which holds all postcodes and lat/long values
            + with above call
            + below query
            = All valid postcodes in that range

            class PostCodes {
                String postcode
                double longitude
                double latitude
            }*/

          def results = PostCodes.findAllByLongitudeBetweenAndLatitudeBetween(lonmin,lonmax,latmin,latmax)
          results.each { found ->
              output += found.postcode
          }
       }
    }
