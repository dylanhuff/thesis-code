This is all my thesis code, which is the actual package (JavaPPTX) and a set of test programs (test). The actual thesis document is located in Thesis.
For the scripts to run, a symlink needs to be made from /JavaPPTX/lib/pptx.jar to /test/src and the npm package
http-server (prevents issues with modules and locally hosting)

//lsof -ti:8080 | xargs kill