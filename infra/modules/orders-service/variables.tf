# Variables del módulo orders-service
# TODO(reto): Define las variables necesarias para configurar el módulo

variable "environment" {
  description = "Entorno donde se desplegará el servicio (dev, prod, etc.)"
  type        = string
}

# TODO(reto): Agrega más variables según los recursos definidos en main.tf