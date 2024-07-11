# mongodb-regex-in-list-query-panache

The purpose of this project is to document an issue of panache in mongodb.

The problem is that the regex query in list is not working with panache

So to query in a array of string field in mongodb with regex 
we can query like this `{ emails: { $in : [ /@email.com/ ] } }` 
this query is working in panache. Even in this work around, there is an issue where it doesn't work with other panache queries.

The problem occurs when I go to make this query in panache
so to do this I use `emails IN $1` then pass the `/@email.com/` as parameter. Now it doesn't work.


## Steps to regenerate the issue
1. Run the project
2. Go to the swagger api on `http://localhost:8080/q/swagger-ui`
3. Hit the `/company/seed` endpoint to populate the db
4. Hit the `/company/notWorkingRegexFindInListSingle` endpoint to get empty result
5. Expected was to get some result