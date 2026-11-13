# Configuración del entorno de desarrollo
# TODO(reto): Define los recursos específicos para el entorno dev

module "orders_service" {
  source      = "../../modules/orders-service"
  environment = "dev"
}

# TODO(reto): Agrega recursos adicionales específicos para desarrollo