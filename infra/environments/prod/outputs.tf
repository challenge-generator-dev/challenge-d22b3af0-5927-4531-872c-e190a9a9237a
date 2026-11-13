output "environment_name" {
  description = "Nombre del entorno de producción"
  value       = var.environment
}

output "dynamodb_table_arn" {
  description = "ARN de la tabla DynamoDB del servicio de órdenes en producción"
  value       = module.orders_service.dynamodb_table_arn
}

output "prod_infrastructure_warning" {
  description = "Advertencia sobre recursos de producción que generan costos"
  value       = "Los recursos de producción en AWS generan costos. Verificar uso antes de aplicar cambios."
}