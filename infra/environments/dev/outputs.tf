output "environment_name" {
  description = "Nombre del entorno de desarrollo"
  value       = var.environment
}

output "dynamodb_table_arn" {
  description = "ARN de la tabla DynamoDB del servicio de órdenes en desarrollo"
  value       = module.orders_service.dynamodb_table_arn
}