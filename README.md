# Aprovisionamiento de Infraestructura con Terraform para el Servicio de Órdenes

El objetivo es aprovisionar la infraestructura AWS necesaria para el servicio de órdenes utilizando Terraform. La infraestructura debe ser versionada para garantizar la trazabilidad y el control de versiones.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Infraestructura como codigo para el servicio de ordenes |
| **Nivel** | senior-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 8 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y entregará cada archivo con su ruta.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y entregará cada archivo con su ruta. Guárdalos en la carpeta donde quieras trabajar, respetando las rutas.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no entrega todos los archivos al terminar el análisis, escríbele: "entrégame todos los archivos con su ruta".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Configuración Inicial

**Objetivo:** Configurar el entorno de Terraform y definir la estructura básica del proyecto.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Configurar el entorno de Terraform.
- Definir la estructura básica del proyecto de Terraform.
- Identificar los recursos AWS necesarios para el servicio de órdenes.

**Entregable:** Proyecto de Terraform con estructura básica y recursos identificados.

<details>
<summary>Pistas de conocimiento</summary>

- Uso de Terraform para aprovisionar infraestructura.
- Identificación de recursos AWS necesarios para un servicio.

</details>

### Fase 2: Definición de Recursos

**Objetivo:** Definir los recursos AWS necesarios en el archivo de Terraform.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Crear los archivos de Terraform para definir los recursos AWS.
- Incluir los recursos necesarios para el servicio de órdenes.
- Asegurar que los recursos estén correctamente configurados.

**Entregable:** Archivos de Terraform con los recursos AWS definidos.

<details>
<summary>Pistas de conocimiento</summary>

- Definición de recursos en Terraform.
- Configuración de recursos AWS.

</details>

### Fase 3: Aprovisionamiento y Versionado

**Objetivo:** Aprovisionar la infraestructura y versionar el proyecto de Terraform.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Ejecutar los comandos de Terraform para aprovisionar la infraestructura.
- Versionar el proyecto de Terraform en un repositorio de control de versiones.
- Verificar que la infraestructura se ha aprovisionado correctamente.

**Entregable:** Infraestructura AWS aprovisionada y proyecto de Terraform versionado.

<details>
<summary>Pistas de conocimiento</summary>

- Uso de comandos de Terraform para aprovisionar infraestructura.
- Versionado de proyectos en repositorios de control de versiones.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es Terraform y cómo se utiliza para aprovisionar infraestructura?
- **paraQueSirve**: ¿Para qué sirve versionar la infraestructura en un repositorio de control de versiones?
- **comoSeUsa**: ¿Cómo se definen y configuran los recursos AWS en Terraform?

## Criterios de Evaluacion

- Configuración correcta del entorno de Terraform.
- Definición adecuada de los recursos AWS en los archivos de Terraform.
- Aprovisionamiento exitoso de la infraestructura AWS.
- Versionado del proyecto de Terraform en un repositorio de control de versiones.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT) si no tenes un agente en el IDE. Declara lo mismo que AGENTS.md; los archivos que te devuelva el chat los guardas en esta carpeta respetando las rutas.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

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

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
(cd infra && terraform init -backend=false && terraform -chdir=environments/dev init -backend=false && terraform -chdir=environments/prod init -backend=false && terraform -chdir=environments/shared init -backend=false && terraform -chdir=modules/orders-service init -backend=false && terraform validate && terraform -chdir=environments/dev validate && terraform -chdir=environments/prod validate && terraform -chdir=environments/shared validate && terraform -chdir=modules/orders-service validate) && (cd api && mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package)
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
