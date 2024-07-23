package main.Java.tu.paquete;

public class NotificadorEmail {
    private EmailCliente emailCliente;

    public NotificadorEmail(EmailCliente emailCliente) {
        this.emailCliente = emailCliente;
    }

    public void notificar(String direccion, String mensaje) {
        if (direccion == null || direccion.isEmpty() || mensaje == null || mensaje.isEmpty()) {
            // No enviar el correo si la dirección o el mensaje son nulos o vacíos
            return;
        }
        emailCliente.enviarCorreo(direccion, mensaje);
    }
}
