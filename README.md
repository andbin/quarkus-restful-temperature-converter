# Quarkus RESTful Temperature Converter

The &ldquo;Quarkus RESTful Temperature Converter&rdquo; is a simple demonstrative application that exposes a RESTful web service for **temperature conversion** developed with [Quarkus](https://quarkus.io) (the &ldquo;Supersonic Subatomic&rdquo; Java Framework).

The application currently supports 6 temperature units: Celsius &ndash; Fahrenheit &ndash; Kelvin &ndash; Rankine &ndash; Réaumur &ndash; Rømer

This project is exclusively developed by [Andrea Binello](https://andbin.it/who-i-am) (&ldquo;andbin&rdquo;).

## License

This project is released under the **MIT License**, a very *permissive* free software license. See the full text of the license:

* [MIT License](MIT-LICENSE.md)
* [MIT License (plain text)](MIT-LICENSE.txt)

You can also see external resources like [here](https://opensource.org/licenses/MIT "The MIT License (MIT) | Open Source Initiative") or [here](https://choosealicense.com/licenses/mit/ "MIT License - Choose a License").

## How to build/run

The project requires at least:

* a JDK 11 or later version
* a very recent version of Maven (e.g. Maven 3.6.3 is ok)

Then you can build and run the application with:

```shell
mvn compile quarkus:dev
```

or using the Maven &ldquo;wrapper&rdquo; with:

```shell
mvnw compile quarkus:dev
```

## REST API

The REST API is very simple and consists of only 3 endpoints. You can try and test the API using [curl](https://curl.se) or [Postman](https://www.postman.com/downloads/) or any other similar tool.

### :small_blue_diamond: Endpoint 1: Get all temperature units

&#8594; GET <code>http://<em>host</em>:<em>port</em>/temperatures</code>

#### Example

```shell
curl http://localhost:8080/temperatures
```

Output (JSON):

```console
[ {
  "code" : "celsius",
  "name" : "Celsius",
  "symbol" : "°C"
}, {
  "code" : "fahrenheit",
  "name" : "Fahrenheit",
  "symbol" : "°F"
},

    ......other units, truncated for brevity

]
```

### :small_blue_diamond: Endpoint 2: Get temperature unit detail

&#8594; GET <code>http://<em>host</em>:<em>port</em>/temperatures/{unit}</code>

#### Example 1

```shell
curl http://localhost:8080/temperatures/celsius
```

Output (JSON):

```console
{
  "code" : "celsius",
  "name" : "Celsius",
  "symbols" : [ "°C" ],
  "waterFreezingPoint" : 0.0,
  "waterBoilingPoint" : 100.0,
  "namedAfter" : "Anders Celsius",
  "establishmentYear" : 1742
}
```

#### Example 2

```shell
curl http://localhost:8080/temperatures/rankine
```

Output (JSON):

```console
{
  "code" : "rankine",
  "name" : "Rankine",
  "symbols" : [ "°R", "°Ra" ],
  "waterFreezingPoint" : 491.67,
  "waterBoilingPoint" : 671.67,
  "namedAfter" : "William John Macquorn Rankine",
  "establishmentYear" : 1859
}
```

### :small_blue_diamond: Endpoint 3: Get temperature conversion

&#8594; GET <code>http://<em>host</em>:<em>port</em>/temperatures/{fromUnit}/{toUnit}/{value}?d={fractionalDigits}</code>

Query param **`d`** is the number of *fractional digits* used for rounding the result. It can be a value from 0 to 7 and is **optional** (default value: 4).

#### Example

```shell
curl http://localhost:8080/temperatures/celsius/fahrenheit/32.7
```

Output (JSON):

```console
{
  "from" : {
    "value" : 32.7,
    "name" : "Celsius",
    "symbol" : "°C"
  },
  "to" : {
    "value" : 90.86,
    "name" : "Fahrenheit",
    "symbol" : "°F"
  }
}
```

### Notes on temperature units specified in urls

In path templates you can use the full code/name (lower case) of a temperature unit or any possible abbreviation (prefix):

```
http://localhost:8080/temperatures/celsius
http://localhost:8080/temperatures/celsiu
http://localhost:8080/temperatures/celsi
http://localhost:8080/temperatures/cels
http://localhost:8080/temperatures/cel
```

etc... are all **OK**. The important thing is that there is no ambiguity between multiple temperature units!
