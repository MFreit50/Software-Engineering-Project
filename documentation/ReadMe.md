Assignment 6:
•	Why won’t Gradle build ServiceImpl files
o	Because the imports from ServiceImpl files were not being recognized
•	Why were the imports not being recognized?
o	Because the import package structure was not set up properly
o	We fixed this by making different package structures for data and compute engines
•	Why wasn’t the package structure set up properly?
o	Because of oversights in naming conventions in our .proto files
•	Why did errors in naming conventions cause import errors?
o	Because the proto file name was the same as our implementation class
o	We fixed the naming errors by renaming our proto files so it did not generate classes with the same names of our class implementations
•	Why did the same file names for .proto and .java cause errors when structuring packages?
o	Because generated classes inside the grpc folder caused conflicting file names and import errors

