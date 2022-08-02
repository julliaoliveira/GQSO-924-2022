package app;

import io.jooby.annotations.*;
import io.jooby.exception.BadRequestException;

@Path("/sub/{n1}/{n2}")
public class Subtracao {

    @GET
    public double calcularSubtracao(@PathParam String n1, @PathParam String n2) {
        try {
          double subtracao = Float.parseFloat(n1) - Float.parseFloat(n2);
          return subtracao;
        } catch (NumberFormatException nfe) {
          throw new BadRequestException("Parâmetros inválidos!");
        }
    }
}
