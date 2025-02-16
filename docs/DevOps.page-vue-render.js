
    var pageVueRenderFn = function noop (a, b, c) {};
    var pageVueStaticRenderFns = [function anonymous(
) {
with(this){return _c('h2',{attrs:{"id":"build-automation"}},[_v("Build automation"),_c('a',{staticClass:"fa fa-anchor",attrs:{"href":"#build-automation","onclick":"event.stopPropagation()"}})])}
},function anonymous(
) {
with(this){return _c('p',[_v("This project uses Gradle for "),_c('strong',[_v("build automation and dependency management")]),_v(". "),_c('strong',[_v("You are recommended to read "),_c('a',{attrs:{"href":"https://se-education.org/guides/tutorials/gradle.html"}},[_v("this Gradle Tutorial from the se-edu/guides")])]),_v(".")])}
},function anonymous(
) {
with(this){return _c('ul',[_c('li',[_c('p',[_c('strong',[_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("clean")])]),_v(": Deletes the files created during the previous build tasks (e.g. files in the "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("build")]),_v(" folder)."),_c('br'),_v("\ne.g. "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("./gradlew clean")])])]),_v(" "),_c('li',[_c('p',[_c('strong',[_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("shadowJar")])]),_v(": Uses the ShadowJar plugin to creat a fat JAR file in the "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("build/lib")]),_v(" folder, "),_c('em',[_v("if the current file is outdated")]),_v("."),_c('br'),_v("\ne.g. "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("./gradlew shadowJar")]),_v(".")])]),_v(" "),_c('li',[_c('p',[_c('strong',[_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("run")])]),_v(": Builds and runs the application."),_c('br'),_v(" "),_c('strong',[_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("runShadow")])]),_v(": Builds the application as a fat JAR, and then runs it.")])]),_v(" "),_c('li',[_c('p',[_c('strong',[_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("checkstyleMain")])]),_v(": Runs the code style check for the main code base."),_c('br'),_v(" "),_c('strong',[_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("checkstyleTest")])]),_v(": Runs the code style check for the test code base.")])]),_v(" "),_c('li',[_c('p',[_c('strong',[_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("test")])]),_v(": Runs all tests.")]),_v(" "),_c('ul',[_c('li',[_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("./gradlew test")]),_v(" — Runs all tests")]),_v(" "),_c('li',[_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("./gradlew clean test")]),_v(" — Cleans the project and runs tests")])])])])}
},function anonymous(
) {
with(this){return _c('h2',{attrs:{"id":"continuous-integration-ci"}},[_v("Continuous integration (CI)"),_c('a',{staticClass:"fa fa-anchor",attrs:{"href":"#continuous-integration-ci","onclick":"event.stopPropagation()"}})])}
},function anonymous(
) {
with(this){return _c('p',[_v("This project uses GitHub Actions for CI. The project comes with the necessary GitHub Actions configurations files (in the "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v(".github/workflows")]),_v(" folder). No further setting up required.")])}
},function anonymous(
) {
with(this){return _c('h3',{attrs:{"id":"code-coverage"}},[_v("Code coverage"),_c('a',{staticClass:"fa fa-anchor",attrs:{"href":"#code-coverage","onclick":"event.stopPropagation()"}})])}
},function anonymous(
) {
with(this){return _c('p',[_v("To enable Codecov for forks of this project, follow the steps given in "),_c('a',{attrs:{"href":"https://se-education.org/guides/tutorials/codecov.html"}},[_v("this se-edu guide")]),_v(".")])}
},function anonymous(
) {
with(this){return _c('h3',{attrs:{"id":"repository-wide-checks"}},[_v("Repository-wide checks"),_c('a',{staticClass:"fa fa-anchor",attrs:{"href":"#repository-wide-checks","onclick":"event.stopPropagation()"}})])}
},function anonymous(
) {
with(this){return _c('p',[_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("./config/travis/run-checks.sh")])])}
},function anonymous(
) {
with(this){return _c('p',[_c('strong',[_v("If adding new checks:")])])}
},function anonymous(
) {
with(this){return _c('ul',[_c('li',[_c('p',[_v("Checks are implemented as executable "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("check-*")]),_v(" scripts within the "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v(".github")]),_v(" directory. The "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("run-checks.sh")]),_v(" script will automatically pick up and run files named as such. That is, you can add more such files if you need and the CI will do the rest.")])]),_v(" "),_c('li',[_c('p',[_v("Check scripts should print out errors in the format "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("SEVERITY:FILENAME:LINE: MESSAGE")])]),_v(" "),_c('ul',[_c('li',[_v("SEVERITY is either ERROR or WARN.")]),_v(" "),_c('li',[_v("FILENAME is the path to the file relative to the current directory.")]),_v(" "),_c('li',[_v("LINE is the line of the file where the error occurred and MESSAGE is the message explaining the error.")])])]),_v(" "),_c('li',[_c('p',[_v("Check scripts must exit with a non-zero exit code if any errors occur.")])])])}
},function anonymous(
) {
with(this){return _c('h2',{attrs:{"id":"making-a-release"}},[_v("Making a release"),_c('a',{staticClass:"fa fa-anchor",attrs:{"href":"#making-a-release","onclick":"event.stopPropagation()"}})])}
},function anonymous(
) {
with(this){return _c('ol',[_c('li',[_v("Update the version number in "),_c('a',{attrs:{"href":"https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/MainApp.java"}},[_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("MainApp.java")])]),_v(".")]),_v(" "),_c('li',[_v("Generate a fat JAR file using Gradle (i.e., "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("gradlew shadowJar")]),_v(").")]),_v(" "),_c('li',[_v("Tag the repo with the version number. e.g. "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("v0.1")])]),_v(" "),_c('li',[_c('a',{attrs:{"href":"https://help.github.com/articles/creating-releases/"}},[_v("Create a new release using GitHub")]),_v(". Upload the JAR file you created.")])])}
}];
  