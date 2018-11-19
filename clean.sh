#!/bin/bash

# find all copies (~) and classfiles and remove

find . -name '*~' | xargs rm -f
find . -name '*.class' | xargs rm -f