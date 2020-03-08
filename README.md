# Author Search
**Stepstone assignment:**
-

**Description:**

For given public REST API from Penguin Random House for author search and possible search opportunities (search by firstName and lastName),
list all authors with their unique ids in system, names and number of titles. In case author took contribution is other written resource,
REST API would return more author objects with same author name and different ids. List all author ids with corresponding number of titles.

**Useful Information:**

A Java application which enables its users to search authors by first name and last name. Search parameters could be provided as program arguments.
REST API for author search is http://www.penguinrandomhouse.biz/webservices/rest/#authors, parameter names for search are firstName and lastName correspondingly for author's first name and last name.

**Example:**

For input parameters: firstName = Dan and  lastName= Brown, application would print:

 - 3446; BROWN, DAN; 68
 - 224942; BROWN, DAN; 0
 - 2182290; BROWN, DAN; 3
