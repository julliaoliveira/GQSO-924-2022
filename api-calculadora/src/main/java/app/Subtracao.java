package app;

import io.jooby.annotations.*;
import io.jooby.exception.BadRequestException;

@Path("/sub/{x}/{y}")
public class Subtracao {

    @GET
    public double calcularSubtracao(@PathParam String x, @PathParam String y) {
        try {
          double subtracao = Float.parseFloat(x) - Float.parseFloat(y);
          return subtracao;
        } catch (NumberFormatException nfe) {
          throw new BadRequestException("Parâmetros inválidos!");
        }
    }
}
