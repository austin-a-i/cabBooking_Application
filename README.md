# Cab Booking Application
 ---------------------------------------
Features:
 ---------------------------------------     
 
The application allows users to book rides on a route.   
Users can register themself.    
Driving partners can onboard on the system with the vehicle details     
Users can search and select one from multiple available rides(selected after calculating min. distance) on a route with the same source and destination based on the nearest to the user.    
Once a ride is selected, its availability status is switched to FALSE so that its not available for selection.     


Application Endpoints
---------------------------------

User Controller
----------------------

Get All Users (for viewing aspect)        
curl -i -X GET \
 'http://localhost:8080/users/all'      

Add User
curl -i -X POST \
   -H "Content-Type:application/json" \
   -d \
'{
  "username": "alboa",
  "sex": "M",
  "age": 23
}' \
 'http://localhost:8080/users/add'       

 Driving Partner Controller
----------------------      

Get All Drivers (For viewing purpose) - Confirms that the cab will not be shown for booking once its availabity status changes.     
curl -i -X GET \
 'http://localhost:8080/driver/all'      

 Add Driver        
 curl -i -X POST \
   -H "Content-Type:application/json" \
   -d \
'    {
        "driverName": "Driver4",
        "sex": "M",
        "vehicle": {
            "vehicleName": "Swift",
            "vehicleNo": "KA-01-12345"
        },
        "location": {
            "latitude": "10",
            "longitude": "3"
        }
    }
]' \
 'http://localhost:8080/driver/add'          

   
 Find Ride - Shows the options for the User based on source location         
 curl -i -X GET \
 'http://localhost:8080/driver/findCab?name=Abhishek&source=(10%2C0)&destination=(20%2C1)'      

      
 Choose Ride - Chooses the cab out of available options( Min. Waiting Time).            
 If no options are available, it will throw NoCabFound response.      
 curl -i -X GET \
 'http://localhost:8080/driver/chooseCab?name=Abhishek&source=(10%2C0)&destination=(20%2C1)'      

 
 

 


 
