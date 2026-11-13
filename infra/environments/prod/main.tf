# Configuración del entorno de producción
# TODO(reto): Define los recursos específicos para el entorno prod

module "orders_service" {
  source      = "../../modules/orders-service"
  environment = "prod"
}

# TODO(reto): Agrega recursos adicionales específicos para producción
# Considera alta disponibilidad, escalabilidad y seguridad