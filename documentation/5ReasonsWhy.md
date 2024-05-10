Assignment 6:
    Why won’t Gradle build ServiceImpl files
        Because the imports from ServiceImpl files were not being recognized
    Why were the imports not being recognized?
        Because the import package structure was not set up properly
    Why wasn’t the package structure set up properly?
        Because of oversights in naming conventions in our .proto files
    Why did errors in naming conventions cause import errors?
        Because the proto file name was the same as our implementation class
    Why did the same file names for .proto and .java cause errors when structuring packages?
        Because generated classes inside the grpc folder caused conflicting file names and import errors
