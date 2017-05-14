# CountMeUp ![Build Status](https://travis-ci.org/ThanosKatsikas/CountMeUp.svg?branch=master)
A java application that accepts votes for candidates and returns the results.

 The rules are:
* Each Voter can vote 3 times.
* Each Voter can vote 3 times regardless of the Candidate he voted for.


## To run:
Clone the repository and run with:

```
 mvn spring-boot:run
```

The application creates four candidates and they can be identified by ids: 1, 2, 3, 4.
We assume that the voters are somehow registered elsewhere and we receive requests with integers as ids.

To cast a vote from command line one can do:
```
curl -i -X POST -d "candidate=3&voter=1" localhost:8080/vote
```

This will cast a vote from voter 1 to canidate 3. 

To show the results:
```
curl -i -X GET localhost:8080/results
```

## Testing
The application is unit tested and also runs cucumber scenarios that can be found under resources. 
To run tests:
```
mvn clean test
```

I have also supplied a plain bash script that runs some basic tests against the application.
To run:
```
./src/test/bash/functional_test.sh
```

