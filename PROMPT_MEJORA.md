# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener el proyecto completo y arrancable. Guarda los archivos que te devuelva en la
carpeta del repo, respetando exactamente las rutas.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Superficie de practica — NO resuelvas

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs.

- `infra/modules/orders-service/main.tf` — El topic pide escribir Terraform: este .tf es el ejercicio, no scaffolding.
- `infra/modules/orders-service/variables.tf` — El topic pide escribir Terraform: este .tf es el ejercicio, no scaffolding.
- `infra/modules/orders-service/outputs.tf` — El topic pide escribir Terraform: este .tf es el ejercicio, no scaffolding.
- `infra/environments/dev/main.tf` — El topic pide escribir Terraform: este .tf es el ejercicio, no scaffolding.
- `infra/environments/prod/main.tf` — El topic pide escribir Terraform: este .tf es el ejercicio, no scaffolding.

## Mapa de componentes

El repo tiene una carpeta por componente. Cada uno se instala y verifica dentro de la suya.

| Componente | Carpeta | Rol | Capa | Track | Tecnologias |
|---|---|---|---|---|---|
| `infra` | `infra/` | practice | infra | Terraform (AWS) | Terraform |
| `api` | `api/` | chapter, support | server | Java | - |

## Orden de arranque

1. `cd infra && terraform init -backend=false && terraform -chdir=environments/dev init -backend=false && terraform -chdir=environments/prod init -backend=false && terraform -chdir=environments/shared init -backend=false && terraform -chdir=modules/orders-service init -backend=false && terraform validate && terraform -chdir=environments/dev validate && terraform -chdir=environments/prod validate && terraform -chdir=environments/shared validate && terraform -chdir=modules/orders-service validate` — componente `infra` (practice).
2. `cd api && mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package` — componente `api` (chapter, support).

### Contratos entre componentes

- `api` expone http (api: http://localhost:8080):
  - `POST /api/orders`
  - `GET /api/orders/{id}`

## Como saber que terminaste

```bash
(cd infra && terraform init -backend=false && terraform -chdir=environments/dev init -backend=false && terraform -chdir=environments/prod init -backend=false && terraform -chdir=environments/shared init -backend=false && terraform -chdir=modules/orders-service init -backend=false && terraform validate && terraform -chdir=environments/dev validate && terraform -chdir=environments/prod validate && terraform -chdir=environments/shared validate && terraform -chdir=modules/orders-service validate) && (cd api && mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package)
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Backend, Especialidad Desarrollador, Tecnología Java, Senior L2

### Brecha de conocimiento
Aprovisionar infraestructura con Terraform, Aprovisiona con Terraform la infraestructura AWS que necesita el servicio de ordenes

### Misión / candidato
Versionar la infraestructura del servicio

### Reto
- Tema: Infraestructura como codigo para el servicio de ordenes
- Seniority: senior-l2
- Tipo: practical
- Título: Aprovisionamiento de Infraestructura con Terraform para el Servicio de Órdenes
- Tiempo estimado: 8 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Configuración Inicial — objetivo: Configurar el entorno de Terraform y definir la estructura básica del proyecto. — entregable (NO resolver): Proyecto de Terraform con estructura básica y recursos identificados.
- Fase 2: Definición de Recursos — objetivo: Definir los recursos AWS necesarios en el archivo de Terraform. — entregable (NO resolver): Archivos de Terraform con los recursos AWS definidos.
- Fase 3: Aprovisionamiento y Versionado — objetivo: Aprovisionar la infraestructura y versionar el proyecto de Terraform. — entregable (NO resolver): Infraestructura AWS aprovisionada y proyecto de Terraform versionado.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (entrega de archivos).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Entrega de archivos
Entregá cada archivo con su ruta completa, respetando exactamente la estructura de rutas
indicada por los marcadores: un bloque por archivo, precedido por su ruta. No generes ZIPs
ni archivos adjuntos.
La entrega debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: Entregá los archivos completos al finalizar. No preguntes si el usuario
quiere recibirlos. Simplemente entregalos; No debes desplegar en el chat el resumen de lo que arreglaste, solo entregá los archivos.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del último archivo entregado
No preguntes si el usuario quiere los archivos: simplemente entregalos siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: infra/README.md ===
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

// === ARCHIVO: infra/environments/dev/terraform.tfvars ===
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

// === ARCHIVO: infra/versions.tf ===
terraform {
  required_version = ">= 1.9.0, < 2.0.0"

  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "= 5.100.0"
    }
  }
}

// === ARCHIVO: infra/providers.tf ===
provider "aws" {
  region = "us-east-1"
}

// === ARCHIVO: infra/modules/orders-service/main.tf ===
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

// === ARCHIVO: infra/modules/orders-service/variables.tf ===
# Variables del módulo orders-service
# TODO(reto): Define las variables necesarias para configurar el módulo

variable "environment" {
  description = "Entorno donde se desplegará el servicio (dev, prod, etc.)"
  type        = string
}

# TODO(reto): Agrega más variables según los recursos definidos en main.tf

// === ARCHIVO: infra/modules/orders-service/outputs.tf ===
# Salidas del módulo orders-service
# TODO(reto): Define las salidas necesarias para otros módulos o entornos

output "dynamodb_table_arn" {
  description = "ARN de la tabla DynamoDB de órdenes"
  value = null # TODO(reto): aws_dynamodb_table.orders_table.arn
}

# TODO(reto): Agrega más outputs según los recursos definidos

// === ARCHIVO: infra/environments/shared/variables.tf ===
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

// === ARCHIVO: infra/environments/dev/main.tf ===
# Configuración del entorno de desarrollo
# TODO(reto): Define los recursos específicos para el entorno dev

module "orders_service" {
  source      = "../../modules/orders-service"
  environment = "dev"
}

# TODO(reto): Agrega recursos adicionales específicos para desarrollo

// === ARCHIVO: infra/environments/prod/main.tf ===
# Configuración del entorno de producción
# TODO(reto): Define los recursos específicos para el entorno prod

module "orders_service" {
  source      = "../../modules/orders-service"
  environment = "prod"
}

# TODO(reto): Agrega recursos adicionales específicos para producción
# Considera alta disponibilidad, escalabilidad y seguridad

// === ARCHIVO: infra/environments/dev/outputs.tf ===
output "environment_name" {
  description = "Nombre del entorno de desarrollo"
  value       = var.environment
}

output "dynamodb_table_arn" {
  description = "ARN de la tabla DynamoDB del servicio de órdenes en desarrollo"
  value       = module.orders_service.dynamodb_table_arn
}

// === ARCHIVO: infra/environments/prod/outputs.tf ===
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

// === ARCHIVO: infra/environments/dev/variables.tf ===
variable "environment" {
  type        = string
  description = "Nombre del entorno de despliegue (dev, staging, prod)"
  default     = "dev"
}

// === ARCHIVO: infra/environments/prod/variables.tf ===
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

// === ARCHIVO: api/pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.4.13</version>
        <relativePath/>
    </parent>

    <groupId>com.example</groupId>
    <artifactId>reto</artifactId>
    <version>1.0.0</version>
    <name>reto</name>

    <properties>
        <java.version>21</java.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>com.amazonaws</groupId>
            <artifactId>aws-java-sdk-dynamodb</artifactId>
            <version>1.12.797</version>
        </dependency>
        <dependency>
            <groupId>com.amazonaws</groupId>
            <artifactId>aws-java-sdk-sqs</artifactId>
            <version>1.12.797</version>
        </dependency>
        <dependency>
            <groupId>jakarta.persistence</groupId>
            <artifactId>jakarta.persistence-api</artifactId>
        </dependency>
        <dependency>
            <groupId>jakarta.validation</groupId>
            <artifactId>jakarta.validation-api</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-configuration-processor</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: api/src/main/java/com/example/orders/domain/Order.java ===
package com.example.orders.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Order {
    private final String id;
    private final String customerId;
    private final List<OrderItem> items;
    private OrderStatus status;
    private final LocalDateTime createdAt;

    public Order(String customerId, List<OrderItem> items) {
        this.id = UUID.randomUUID().toString();
        this.customerId = validateCustomerId(customerId);
        this.items = validateItems(items);
        this.status = OrderStatus.CREATED;
        this.createdAt = LocalDateTime.now();
    }

    public Order(String id, String customerId, List<OrderItem> items, OrderStatus status, LocalDateTime createdAt) {
        this.id = validateId(id);
        this.customerId = validateCustomerId(customerId);
        this.items = validateItems(items);
        this.status = status;
        this.createdAt = createdAt;
    }

    private String validateId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Order ID cannot be null or empty");
        }
        return id;
    }

    private String validateCustomerId(String customerId) {
        if (customerId == null || customerId.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer ID cannot be null or empty");
        }
        return customerId;
    }

    private List<OrderItem> validateItems(List<OrderItem> items) {
        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException("Order must contain at least one item");
        }
        items.forEach(item -> {
            if (item.getQuantity() <= 0) {
                throw new IllegalArgumentException("Item quantity must be positive");
            }
            if (item.getPrice() <= 0) {
                throw new IllegalArgumentException("Item price must be positive");
            }
        });
        return items;
    }

    public String getId() {
        return id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public List<OrderItem> getItems() {
        return List.copyOf(items);
    }

    public OrderStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void markAsPaid() {
        this.status = OrderStatus.PAID;
    }

    public void markAsCancelled() {
        this.status = OrderStatus.CANCELLED;
    }

    public double calculateTotal() {
        return items.stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();
    }

    public enum OrderStatus {
        CREATED, PAID, CANCELLED
    }
}

// === ARCHIVO: api/src/main/java/com/example/orders/domain/OrderItem.java ===
package com.example.orders.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class OrderItem {
    private final String productId;
    private final int quantity;
    private final double price;

    public OrderItem(String productId, int quantity, double price) {
        this.productId = validateProductId(productId);
        this.quantity = validateQuantity(quantity);
        this.price = validatePrice(price);
    }

    private String validateProductId(String productId) {
        if (productId == null || productId.trim().isEmpty()) {
            throw new IllegalArgumentException("Product ID cannot be null or empty");
        }
        return productId;
    }

    private int validateQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        return quantity;
    }

    private double validatePrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be positive");
        }
        return price;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}

// === ARCHIVO: api/src/main/java/com/example/orders/domain/OrderRepository.java ===
package com.example.orders.domain;

import java.util.Optional;

public interface OrderRepository {
    Order save(Order order);
    Optional<Order> findById(String id);
}

// === ARCHIVO: api/src/main/java/com/example/orders/application/OrderService.java ===
package com.example.orders.application;

import com.example.orders.domain.Order;
import com.example.orders.domain.OrderRepository;
import com.example.orders.domain.OrderItem;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
@Validated
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(@Valid CreateOrderRequest request) {
        List<OrderItem> items = request.items().stream()
                .map(item -> new OrderItem(item.productId(), item.quantity(), item.price()))
                .toList();

        Order order = new Order(request.customerId(), items);
        return orderRepository.save(order);
    }

    public Optional<Order> getOrder(String id) {
        return orderRepository.findById(id);
    }

    public record CreateOrderRequest(
            @Valid List<OrderItemRequest> items,
            @Valid String customerId) {
    }

    public record OrderItemRequest(
            @Valid String productId,
            @Valid int quantity,
            @Valid double price) {
    }
}

// === ARCHIVO: api/src/main/java/com/example/orders/infrastructure/persistence/OrderJpaRepository.java ===
package com.example.orders.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderJpaRepository extends JpaRepository<OrderEntity, String> {
}

// === ARCHIVO: api/src/main/java/com/example/orders/infrastructure/persistence/OrderEntity.java ===
package com.example.orders.infrastructure.persistence;

import com.example.orders.domain.Order;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    private String id;

    @Column(nullable = false)
    private String customerId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private List<OrderItemEntity> items;

    @Enumerated(EnumType.STRING)
    private Order.OrderStatus status;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    protected OrderEntity() {
    }

    public OrderEntity(Order order) {
        this.id = order.getId();
        this.customerId = order.getCustomerId();
        this.items = order.getItems().stream()
                .map(OrderItemEntity::new)
                .collect(Collectors.toList());
        this.status = order.getStatus();
        this.createdAt = order.getCreatedAt();
    }

    public Order toDomain() {
        return new Order(
                id,
                customerId,
                items.stream()
                        .map(OrderItemEntity::toDomain)
                        .collect(Collectors.toList()),
                status,
                createdAt
        );
    }

    public String getId() {
        return id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public List<OrderItemEntity> getItems() {
        return items;
    }

    public Order.OrderStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}

// === ARCHIVO: api/src/main/java/com/example/orders/infrastructure/persistence/OrderItemEntity.java ===
package com.example.orders.infrastructure.persistence;

import com.example.orders.domain.OrderItem;
import jakarta.persistence.*;

@Entity
@Table(name = "order_items")
public class OrderItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String productId;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private double price;

    protected OrderItemEntity() {
    }

    public OrderItemEntity(OrderItem orderItem) {
        this.productId = orderItem.getProductId();
        this.quantity = orderItem.getQuantity();
        this.price = orderItem.getPrice();
    }

    public OrderItem toDomain() {
        return new OrderItem(productId, quantity, price);
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}

// === ARCHIVO: api/src/main/java/com/example/orders/infrastructure/persistence/OrderRepositoryImpl.java ===
package com.example.orders.infrastructure.persistence;

import com.example.orders.domain.Order;
import com.example.orders.domain.OrderRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderJpaRepository orderJpaRepository;

    public OrderRepositoryImpl(OrderJpaRepository orderJpaRepository) {
        this.orderJpaRepository = orderJpaRepository;
    }

    @Override
    public Order save(Order order) {
        OrderEntity entity = new OrderEntity(order);
        OrderEntity savedEntity = orderJpaRepository.save(entity);
        return savedEntity.toDomain();
    }

    @Override
    public Optional<Order> findById(String id) {
        return orderJpaRepository.findById(id)
                .map(OrderEntity::toDomain);
    }
}

// === ARCHIVO: api/src/main/java/com/example/orders/infrastructure/web/OrderController.java ===
package com.example.orders.infrastructure.web;

import com.example.orders.application.OrderService;
import com.example.orders.application.OrderService.CreateOrderRequest;
import com.example.orders.application.OrderService.OrderItemRequest;
import com.example.orders.domain.Order;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@Valid @RequestBody CreateOrderRequest request) {
        Order order = orderService.createOrder(request);
        OrderResponse response = mapToOrderResponse(order);
        return ResponseEntity.created(URI.create("/api/orders/" + order.getId()))
                .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrder(@PathVariable String id) {
        return orderService.getOrder(id)
                .map(this::mapToOrderResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    private OrderResponse mapToOrderResponse(Order order) {
        List<OrderItemResponse> items = order.getItems().stream()
                .map(item -> new OrderItemResponse(
                        item.getProductId(),
                        item.getQuantity(),
                        item.getPrice()
                ))
                .collect(Collectors.toList());

        return new OrderResponse(
                order.getId(),
                items,
                order.getCustomerId(),
                order.getStatus().name(),
                order.getCreatedAt().toString()
        );
    }

    public record OrderItemResponse(String productId, int quantity, double price) {}

    public record OrderResponse(
            String id,
            List<OrderItemResponse> items,
            String customerId,
            String status,
            String createdAt
    ) {}
}

// === ARCHIVO: api/src/main/resources/application.yml ===
spring:
  datasource:
    url: jdbc:h2:mem:ordersdb;DB_CLOSE_DELAY=-1
    driver-class-name: org.h2.Driver
    username: sa
    password: ""
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true
  h2:
    console:
      enabled: true
      path: /h2-console

server:
  port: 8080

management:
  endpoints:
    web:
      exposure:
        include: health,info,metrics

// === ARCHIVO: api/src/main/java/com/example/orders/OrdersApplication.java ===
package com.example.orders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.orders")
public class OrdersApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrdersApplication.class, args);
    }
}
```
