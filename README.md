1.	Create Rest server based on Spring Boot with next endpoints:
a.	Calculator plus action (two elements)

Expected request 

$ curl -X POST \
  http://{yourIP}:{yourPort}/api/plus \
  -H 'Content-Type: application/json' \
  -d '{
         "firstElement": 2,
        "secondElement": 1,
}'
 
Expected response

{
“result”: 3
}
b.	Calculator minus action (two elements)

Expected request 

$ curl -X POST \
  http://{yourIP}:{yourPort}/api/minus \
  -H 'Content-Type: application/json' \
  -d '{
         "firstElement": 2,
        "secondElement": 1,
}'
 
Expected response

{
“result”: 1
}
c.	Calculator minus multiply (two elements)

Expected request 

$ curl -X POST \
  http://{yourIP}:{yourPort}/api/multiply \
  -H 'Content-Type: application/json' \
  -d '{
         "firstElement": 2,
        "secondElement": 1,
}'
 
Expected response

{
“result”: 2
}
d.	Calculator divide action (two elements)

Expected request 

$ curl -X POST \
  http://{yourIP}:{yourPort}/api/divide \
  -H 'Content-Type: application/json' \
  -d '{
         "firstElement": 2,
        "secondElement": 1,
}'
 
Expected response

{
“result”: 1
}

2.	Please add validation in case of invalid parameters 
Expected request 

$ curl -X POST \
  http://{yourIP}:{yourPort}/api/divide \
  -H 'Content-Type: application/json' \
  -d '{
         "firstElement": “a”,
        "secondElement": 1,
}'
 
Expected response

{
“error”: “Invalid value of firstElement”
}


3.	Please upload your results on github with instructions how to build and run it
4.	(Optional) please upload your result to any free hosting to test



 

