@Reports
Feature: Reports module cross-module count validation

  @OpenJobsReport
  Scenario: Compare Reports Open Jobs count with Jobs Active Jobs count
    Given validate Reports Open Jobs count against Jobs module Active Jobs count

  @RejectedCandidatesReport
  Scenario: Compare Reports Rejected Candidates with Candidate Declined count
    Given validate Reports Rejected Candidates count against Candidate module Declined count

  @UpcomingInterviewsReport
  Scenario: Compare Reports Upcoming Interviews with Calendar events
    Given validate Reports Upcoming Interviews count against Calendar events
