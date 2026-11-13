# Orders Service Infrastructure with Terraform

## Structure
```
.
├── environments/
│   ├── dev/
│   │   ├── main.tf          # Dev environment configuration
│   │   ├── outputs.tf       # Dev outputs
│   │   └── terraform.tfvars # Dev variables
│   ├── prod/
│   │   ├── main.tf          # Prod environment configuration
│   │   └── outputs.tf       # Prod outputs
│   └── shared/
│       └── variables.tf     # Shared variables
├── modules/
│   └── orders-service/      # Orders service module
│       ├── main.tf          # Main module resources
│       ├── variables.tf     # Module variables
│       └── outputs.tf       # Module outputs
├── providers.tf             # AWS provider configuration
└── versions.tf              # Terraform version constraints
```

## Prerequisites
- Terraform 1.9.0
- AWS CLI configured with credentials
- AWS account with permissions to create:
  - Lambda functions
  - API Gateway
  - DynamoDB tables
  - IAM roles

## Setup
1. Initialize Terraform:
   ```bash
   terraform -chdir=environments/dev init
   ```

2. Review the execution plan:
   ```bash
   terraform -chdir=environments/dev plan
   ```

3. Apply the configuration:
   ```bash
   terraform -chdir=environments/dev apply
   ```

## Validation
After applying, verify:
- Lambda function exists in AWS Console
- API Gateway endpoint is deployed
- DynamoDB table is created with correct schema
- IAM roles have proper permissions

## Environment Management
- Use `terraform.tfvars` to override default values
- Each environment (dev/prod) has its own configuration
- Shared variables are defined in `environments/shared/variables.tf`