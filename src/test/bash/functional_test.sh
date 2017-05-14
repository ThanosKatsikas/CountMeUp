echo "Casting Votes ..."
curl -i -X POST -d "candidate=3&voter=1" localhost:8080/vote
curl -i -X POST -d "candidate=3&voter=1" localhost:8080/vote
curl -i -X POST -d "candidate=3&voter=2" localhost:8080/vote
curl -i -X POST -d "candidate=3&voter=2" localhost:8080/vote
curl -i -X POST -d "candidate=3&voter=2" localhost:8080/vote
curl -i -X POST -d "candidate=3&voter=4" localhost:8080/vote
curl -i -X POST -d "candidate=3&voter=4" localhost:8080/vote
curl -i -X POST -d "candidate=1&voter=7" localhost:8080/vote
curl -i -X POST -d "candidate=2&voter=5" localhost:8080/vote
curl -i -X POST -d "candidate=4&voter=4" localhost:8080/vote
curl -i -X POST -d "candidate=1&voter=5" localhost:8080/vote
curl -i -X POST -d "candidate=4&voter=5" localhost:8080/vote

echo "Invalid Candidate test..."
curl -i -X POST -d "candidate=9&voter=1" localhost:8080/vote

echo "More than three votes test..."
curl -i -X POST -d "candidate=2&voter=5" localhost:8080/vote

echo "Results ..."
curl -i -X GET localhost:8080/results

