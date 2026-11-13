variable "environment" {
  type        = string
  description = "Nombre del entorno de despliegue (producción)"
  default     = "prod"
}

variable "aws_region" {
  type        = string
  description = "Región de AWS donde se aprovisionarán los recursos"
  default     = "us-east-1"
}

variable "project_name" {
  type        = string
  description = "Nombre del proyecto para identificar recursos"
  default     = "orders-service"
}