# Variables compartidas entre todos los entornos
variable "environment" {
  description = "Nombre del entorno (dev, prod, etc.)"
  type        = string
  default     = "dev"
}

variable "aws_region" {
  description = "Región AWS donde se desplegarán los recursos"
  type        = string
  default     = "us-east-1"
}

variable "project_name" {
  description = "Nombre del proyecto"
  type        = string
  default     = "orders-service"
}