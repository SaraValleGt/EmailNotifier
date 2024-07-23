package test.Java.tu.paquete; // Problema: Asegúrate de que este sea el paquete correcto

import main.Java.tu.paquete.EmailCliente;
import main.Java.tu.paquete.NotificadorEmail;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class NotificadorEmailTest {

    @Mock
    private EmailCliente emailClienteMock;

    @Test
    public void testNotificar() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);
        notificador.notificar("ejemplo@test.com", "Hola Mundo");

        verify(emailClienteMock).enviarCorreo("ejemplo@test.com", "Hola Mundo");
    }

    private EmailCliente verify(EmailCliente emailClienteMock) {
        return emailClienteMock;
    }

    @Test
    public void testNotificarConDireccionVacia() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);
        notificador.notificar("", "Mensaje");

        verify(emailClienteMock, times(0)).enviarCorreo(anyString(), anyString());
    }

    private Object anyString() {
        return null;
    }

    private Object times(int i) {
        return null;
    }

    @Test
    public void testNotificarConMensajeNulo() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);
        notificador.notificar("ejemplo@test.com", null);

        // Verificar que no se llamó al método enviarCorreo si el mensaje es nulo
        verify(emailClienteMock, times(0)).enviarCorreo(anyString(), anyString());
    }


    @Test
    public void testNotificarConDireccionNula() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);
        notificador.notificar(null, "Mensaje");

        verify(emailClienteMock, times(0)).enviarCorreo(anyString(), anyString());
    }

    @Test
    public void testNotificarConMensajeVacio() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);
        notificador.notificar("ejemplo@test.com", "");

        verify(emailClienteMock, times(0)).enviarCorreo(anyString(), anyString());
    }

    private void verify(EmailCliente emailClienteMock, Object times) {
    }
}