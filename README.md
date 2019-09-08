# whitepages-connector

Spring boot rest API application to provide to external whitepages service which is limited to a single connection supporting sequential requests.

External whitepages service providing faked data

# API

## Get numbers for a given name 

http://{host}:8080/getNumbersFromName/{name}

{host} host running connector
{name} name to lookup on whitepages service

This is likely to respond with multiple responses, faked to 2 only

## Get name for given number

http://{host}:8080/getNameFromNumber/{number}

{host} host running connector
{number} number to lookup on whitepages service


