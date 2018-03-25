/**
 * Jenkins 2.0 Buildfile
 **/

imageArgs = [
    [ "latest",
      "jre",
      settings.oracle_8_java_major_version,
      settings.oracle_8_java_update_version,
      settings.oracle_8_java_build_number,
      settings.oracle_8_java_hash],
    [ "jdk",
      "jdk",
      settings.oracle_8_java_major_version,
      settings.oracle_8_java_update_version,
      settings.oracle_8_java_build_number,
      settings.oracle_8_java_hash],
    [ "jre",
      "jre",
      settings.oracle_8_java_major_version,
      settings.oracle_8_java_update_version,
      settings.oracle_8_java_build_number,
      settings.oracle_8_java_hash],
    [ "server-jre",
      "server-jre",
      settings.oracle_8_java_major_version,
      settings.oracle_8_java_update_version,
      settings.oracle_8_java_build_number,
      settings.oracle_8_java_hash]
  ] as String[][]

dockerImages = ["manoharanrajesh/alpine:3.7"] as String[]

dockerWorkspace = "java-oracle-alpine"

return this;
