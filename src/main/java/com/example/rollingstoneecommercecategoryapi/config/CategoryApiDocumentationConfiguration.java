package com.example.rollingstoneecommercecategoryapi.config;

import io.swagger.annotations.*;

@SwaggerDefinition(
        info = @Info(
                description = "Category REST API Resources",
                version = "V1.0",
                title = "Category REST API Full CRUD",
                contact = @Contact(
                        name = "Sanni Lateef Anjola",
                        email = "sanni.anjola@gmail.com",
                        url = "https://github.com/sanni-anjola"
                ),
                license = @License(
                        name = "APache 2.0",
                        url = "http://www.apache.org/licenses/LICENSE-2.0"
                )
        ),
        consumes = {"application/json"},
        produces = {"application/json"},
        schemes = {SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS},
        externalDocs = @ExternalDocs(value = "For further information", url = "http://www.apache.org/licenses/LICENSE-2.0")
)
public class CategoryApiDocumentationConfiguration {

}
