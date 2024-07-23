package main.Java.tu.paquete;

public class Main {
    public static void main(String[] args) {
        // Crear una instancia de EmailCliente (esto puede ser una implementación real o un mock para prueba)
        EmailCliente emailCliente = new EmailCliente() {
            @Override
            public void enviarCorreo(Object direccion, Object mensaje) {
                // Implementación simple para enviar correo (solo para fines de demostración)
                System.out.println("Enviando correo a: " + direccion);
                System.out.println("Mensaje: " + mensaje);
            }
        };

        // Crear una instancia de NotificadorEmail con el EmailCliente
        NotificadorEmail notificador = new NotificadorEmail(emailCliente);

        // Usar el notificador para enviar un correo
        notificador.notificar("ejemplo@test.com", "Hola Mundo");
    }
}