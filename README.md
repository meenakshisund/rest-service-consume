# rest-service-consume
Rest API call from the app (consume) to fetch Bank details for a specific IFSC code.

REST API used: https://ifsc.razorpay.com/ICIC0000007

GET: http://localhost:8080/{ifscCode}

http://localhost:8080/ICIC0000007

Sample Response:
```json

{
	"BRANCH": "NEW DELHI - CONNAUGHT PLACE┬á",
	"CENTRE": "DELHI",
	"DISTRICT": "DELHI",
	"STATE": "DELHI",
	"ADDRESS": "ICICI Bank Ltd., 9A, Phelps Building, Connaught Place, New Delhi - 110001",
	"CITY": "DELHI",
	"CONTACT": "",
	"MICR": "110229002",
	"BANK": "ICICI Bank",
	"UPI": true,
	"RTGS": true,
	"NEFT": true,
	"IMPS": true
}

```


REST API call using Spring RestTemplate Bean.
```
    @Bean
    public RestTemplate customRestTemplate()
    {
        return new RestTemplate();
    }
    
    customRestTemplate.exchange(new URI(sb.toString()), HttpMethod.GET, null, IfscResponse.class);
    
```

PropertySourcesPlaceHolderConfigurer is used to configure property sources. Created a custom property file called local.properties

```
    @Bean
    public PropertySourcesPlaceholderConfigurer placeholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }
    
    @PropertySource("classpath:local.properties")
```

@Value annotation used to read property value from proerty file(local.properties)
```
    @Value("${razorpay.base.url}")
    private String baseUrl;
```

To run only using Dockerfile:
```
    docker build -f Dockerfile -t "webservice-img" .
    docker run -p 8080:8080 webservice-img
```

Use Dockerfile and docker-compose.yml files:
```
    docker-compose up --build
```


