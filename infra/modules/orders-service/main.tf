# Módulo Terraform para el servicio de órdenes
# TODO(reto): Define los recursos AWS necesarios para el servicio de órdenes.
# Incluye:
# - Base de datos DynamoDB para almacenar órdenes
# - Lambda para procesar órdenes
# - API Gateway para exponer endpoints
# - IAM roles y políticas necesarias

# TODO(reto): implementa este bloque
# resource "aws_dynamodb_table" "orders_table" {
#   # TODO(reto): Configura la tabla DynamoDB
#   name           = "${var.environment}-orders-table"
#   billing_mode   = "PAY_PER_REQUEST"
#   hash_key       = "order_id"
#
#   attribute {
#     name = "order_id"
#     type = "S"
#   }
# }

# TODO(reto): implementa este bloque
# resource "aws_lambda_function" "orders_processor" {
#   # TODO(reto): Configura la Lambda para procesar órdenes
#   function_name = "${var.environment}-orders-processor"
#   role          = aws_iam_role.lambda_exec.arn
#   runtime       = "nodejs20.x"
#   handler       = "index.handler"
#   filename      = "lambda_function.zip"
# }

# TODO(reto): implementa este bloque
# resource "aws_apigatewayv2_api" "orders_api" {
#   # TODO(reto): Configura el API Gateway para exponer endpoints
#   name          = "${var.environment}-orders-api"
#   protocol_type = "HTTP"
# }

# TODO(reto): implementa este bloque
# resource "aws_iam_role" "lambda_exec" {
#   # TODO(reto): Define el rol IAM para la Lambda
#   name = "${var.environment}-orders-lambda-exec"
#
#   assume_role_policy = jsonencode({
#     Version = "2012-10-17"
#     Statement = [
#       {
#         Action = "sts:AssumeRole"
#         Effect = "Allow"
#         Principal = {
#           Service = "lambda.amazonaws.com"
#         }
#       }
#     ]
#   })
# }