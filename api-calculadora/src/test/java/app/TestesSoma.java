package app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import io.jooby.MockRouter;
import io.jooby.StatusCode;

public class TestesSoma {

    @Test
    public void somar() {
        MockRouter router = new MockRouter(new App());
        router.get("/soma/90/90", rsp -> {
            assertEquals(180.0, rsp.value());
            assertEquals(StatusCode.OK, rsp.getStatusCode());
        });
    }
}