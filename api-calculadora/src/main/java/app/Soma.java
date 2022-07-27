package app;

import io.jooby.annotations.*;
import io.jooby.exception.BadRequestException;

@Path("/soma/{x}/{y}")
public class Soma {

    @GET
    public double calcularSoma(@PathParam String x, @PathParam String y) {
        try {
          double soma = Float.parseFloat(x)+Float.parseFloat(y);
          return soma;
        } catch (NumberFormatException nfe) {
          throw new BadRequestException("Parâmetros inválidos!");
        }
    }
}
