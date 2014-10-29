name := Common.classifier

version := Common.version

organization := Common.organization

exportJars := true

exportJars in Test := false

publishArtifact := false

artifactName := { (sv: ScalaVersion, module: ModuleID, artifact: Artifact) =>
  s"${Common.name}-${module.revision}-${module.name}.${artifact.extension}"
}

modelsTask <<= packagedArtifact in (Compile, packageBin) map {
  case (art: Artifact, file: File) => file
}