# Terraform variables for dev environment
# AWS credentials are provided via environment variables or IAM role
# Never hardcode credentials in infrastructure code

# Networking
vpc_cidr_block           = "10.0.0.0/16"
public_subnet_cidrs      = ["10.0.1.0/24", "10.0.2.0/24"]
private_subnet_cidrs     = ["10.0.3.0/24", "10.0.4.0/24"]

# Orders Service Configuration
orders_service_name                = "orders-service-dev"
orders_service_container_port      = 8080
orders_service_host_port           = 8080
orders_service_cpu                 = 256
orders_service_memory              = 512
orders_service_desired_count       = 1
orders_service_health_check_path   = "/health"
orders_service_environment_variables = {
  "SPRING_PROFILES_ACTIVE" = "dev"
  "DB_URL"                 = "jdbc:postgresql://orders-db-dev:5432/orders"
  "DB_USERNAME"            = "orders_user"
  "DB_PASSWORD"            = "orders_password_dev"
}

# Database Configuration
orders_db_name                 = "orders_db_dev"
orders_db_username             = "orders_user"
orders_db_password             = "orders_password_dev"
orders_db_instance_class       = "db.t3.micro"
orders_db_allocated_storage    = 20
orders_db_engine_version       = "13.4"
orders_db_publicly_accessible  = false
orders_db_skip_final_snapshot  = true