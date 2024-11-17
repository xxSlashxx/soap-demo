# SOAP-Demo

## Overview
This repository contains a SOAP-based web service that can be accessed by clients to interact with a set of predefined functionalities. The web service is built using spring-boot-starter-web-services, wsdl4j and provides access to operations through SOAP protocol. It allows for seamless communication between clients and the service by exchanging XML-based messages.

## Services
This demo consists of the following service:
- **Products Service:** Handles product information

## API Endpoints
### Products Service
**createProductRequest:** Creates a new product

## Getting Started
### Prerequisites
- Java 21 or higher
- Git
- Docker

### Clone the Repository
    git clone https://github.com/xxSlashxx/soap-demo
    cd soap-demo

### Running the Application

    docker compose up

### Accessing the Services
The service's endpoints can be accessed through `http://localhost:8080/api/v1/products`.

#### Example SOAP Request

    <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:gs="http://www.slash.de/productsservice/gen">
    <soapenv:Header/>
        <soapenv:Body>
            <gs:createProductRequest>
                <gs:productDTO>
                    <gs:name>Clean Code</gs:name>
                    <gs:price>29.99</gs:price>
                </gs:productDTO>
            </gs:createProductRequest>
        </soapenv:Body>
    </soapenv:Envelope>

### Testing
You can test the SOAP service using tools like Postman or by sending raw SOAP requests via curl or any HTTP client library.

Example using `curl`:

        curl -X POST -H "Content-Type: text/xml" -d @soap-request.xml http://localhost:8080/api/v1/products

Make sure to replace `soap-request.xml`with your actual SOAP request file.

### Configuration
Configuration settings can be found in the application.properties files located in the service's src/main/resources directory. You can customize properties like database connections and port numbers.

