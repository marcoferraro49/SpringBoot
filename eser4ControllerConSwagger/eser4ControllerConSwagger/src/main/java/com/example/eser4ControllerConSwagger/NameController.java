package com.example.eser4ControllerConSwagger;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ciao")
public class NameController {

    @Operation(summary = "Get Name", description = "Restituisce il nome fornito come parametro")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Correct", content = @Content(schema = @Schema(type = "string"), examples = {
                    @ExampleObject(name = "Example", value = "Marco")
            })),
            @ApiResponse(responseCode = "400", description = "Bad Request")
    })
    @GetMapping("/name")
    public String getName (@RequestParam String name) {
        return name;
    }

    @Operation(summary = "Get Name Reversed", description = "Restituisce il nome fornito come parametro ma al contrario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Correct", content = @Content(schema = @Schema(type = "string"), examples = {
                    @ExampleObject(name = "Example", value = "ocraM")
            })),
            @ApiResponse(responseCode = "400", description = "Bad Request")
    })
    @PostMapping("/name/reverse")
    public String getReversedName (@RequestParam String name) {
        StringBuilder reversedName = new StringBuilder(name);
        return reversedName.reverse().toString();
    }
}
