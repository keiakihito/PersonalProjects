# Distributed under the OSI-approved BSD 3-Clause License.  See accompanying
# file Copyright.txt or https://cmake.org/licensing for details.

cmake_minimum_required(VERSION 3.5)

file(MAKE_DIRECTORY
  "/Users/keita-katsumi/Dropbox/Academic/PCC/2022/2022Fall/CS3A/week5/09_p3_p5_lab_and_plane/cmake-build-debug/_deps/googletest-src"
  "/Users/keita-katsumi/Dropbox/Academic/PCC/2022/2022Fall/CS3A/week5/09_p3_p5_lab_and_plane/cmake-build-debug/_deps/googletest-build"
  "/Users/keita-katsumi/Dropbox/Academic/PCC/2022/2022Fall/CS3A/week5/09_p3_p5_lab_and_plane/cmake-build-debug/_deps/googletest-subbuild/googletest-populate-prefix"
  "/Users/keita-katsumi/Dropbox/Academic/PCC/2022/2022Fall/CS3A/week5/09_p3_p5_lab_and_plane/cmake-build-debug/_deps/googletest-subbuild/googletest-populate-prefix/tmp"
  "/Users/keita-katsumi/Dropbox/Academic/PCC/2022/2022Fall/CS3A/week5/09_p3_p5_lab_and_plane/cmake-build-debug/_deps/googletest-subbuild/googletest-populate-prefix/src/googletest-populate-stamp"
  "/Users/keita-katsumi/Dropbox/Academic/PCC/2022/2022Fall/CS3A/week5/09_p3_p5_lab_and_plane/cmake-build-debug/_deps/googletest-subbuild/googletest-populate-prefix/src"
  "/Users/keita-katsumi/Dropbox/Academic/PCC/2022/2022Fall/CS3A/week5/09_p3_p5_lab_and_plane/cmake-build-debug/_deps/googletest-subbuild/googletest-populate-prefix/src/googletest-populate-stamp"
)

set(configSubDirs )
foreach(subDir IN LISTS configSubDirs)
    file(MAKE_DIRECTORY "/Users/keita-katsumi/Dropbox/Academic/PCC/2022/2022Fall/CS3A/week5/09_p3_p5_lab_and_plane/cmake-build-debug/_deps/googletest-subbuild/googletest-populate-prefix/src/googletest-populate-stamp/${subDir}")
endforeach()
