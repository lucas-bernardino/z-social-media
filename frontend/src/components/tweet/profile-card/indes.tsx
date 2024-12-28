import SplitedContainer from "@/components/splited-container";
import { Button } from "@/components/ui/button";
import { HoverCard, HoverCardTrigger, HoverCardContent } from "@/components/ui/hover-card";

export default function ProfileCard() {

  const profile = {
    login: "Lucas Bernardino"
  }

  return (

    <HoverCard>
      <HoverCardTrigger className="cursor-pointer">
        {profile.login}
      </HoverCardTrigger>
      <HoverCardContent>
        <SplitedContainer>
          <Button variant={"default"} className="w-full rounded-full">Seguir</Button>
        </SplitedContainer>
      </HoverCardContent>
    </HoverCard>

  )

}
