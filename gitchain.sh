#!/bin/bash

git push gitlab refine &&
git checkout master &&
git merge refine &&
git push gitlab master &&
git push heroku master &&
git checkout sample &&
git merge master -m "merge master" &&
git push github sample