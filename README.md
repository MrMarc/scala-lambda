# scala-lambda

A Hello, World style app for AWS Lambda in Scala. This project creates and deploys a layer. It's also intended to demonstrate using AWS's SnapStart.

## Requirements

This example project uses SBT for building Scala projects and Amazon's SAM CLI app
for testing, packaging, and deploying AWS Lambda functions. You'll need all of the following to complete the tutorial:

1. [SBT](https://www.scala-sbt.org/) • The Scala Build Tool
2. [SAM CLI](https://aws.amazon.com/serverless/sam/) • The AWS Serverless Application Model app (a wrapper around AWS CloudFormation and the CLI)
3. [AWS CLI](https://aws.amazon.com/cli/) • The popular CLI for accessing the AWS API
4. [Docker](https://www.docker.com/) • Required by SAM for local testing of Lambda functions
5. curl • The performant web client used to test the running Lambda functions (NOT PRESENTLY USED)
6. An AWS account and valid credentials

## Building and Running The Function Locally

Open your terminal to the project directory and run the following to build and run the function locally:

    $ sbt assembly && sam packageLayer

The `sbt assembly` command compiles the function and packages it in a JAR file. It also removes some JAR files from the assembly. The `sbt packageLayer` command builds a zip file that contains the JAR files removed in the assembly and makes a Zipfile as a deployable Lambda layer.

`sam build` will build the appropriate artifacts for SAM ... (NOTE: it won't build the scala pieces).

To run/test locally:

`sam local invoke -e event.json`

To deploy to AWS (assuming the default keys are set), `sam deploy --guided` for the first deployment. Choose a name and the defaults should be acceptable.

Presently, the API Gateway doesn't work but you can invoke the Lambda remotely with any text as the inbound content. This can be done in the AWS console, with the AWS cli or with a specific IDE plugin like the AWS plugin for vscode.