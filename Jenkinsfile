stage 'build_Project'
node{
  if(isUnix()){
  sh 'gradlew build --info'

  }
  else{
    bat 'gradlew build --info'
  }
}