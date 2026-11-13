# Salidas del módulo orders-service
# TODO(reto): Define las salidas necesarias para otros módulos o entornos

output "dynamodb_table_arn" {
  description = "ARN de la tabla DynamoDB de órdenes"
  value = null # TODO(reto): aws_dynamodb_table.orders_table.arn
}

# TODO(reto): Agrega más outputs según los recursos definidos